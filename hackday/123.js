/**
 * Created by yifan on 16/1/31.
 */
function Calendar(config){

    config=config||{};
    if((typeof config)!="object"){
        return;
    }
    for(var p in config){
        this[p]=config[p];
    }
    this.datas=new Map();
    //this.datasId="guestCalendar";
    this.selectDay=null;
    this.selectTime=null;
    this.selectKey=null;
    var DOC=document,getElement=function(id){return DOC.getElementById(id);};
    //对应的ids 0 显示年的  1 显示 月的 2 显示天的
    this.calendarIds=['easyJsYear','easyJsMonth','easyJsShowDate'];
    this.init=function(){
        var d=new Date();
        this.currentMonth=d.getMonth()+1;
        this.currentYear=d.getFullYear();
        d=null;
    };
    this.initShowCalendar=function(){
        this.year=this.currentYear;
        this.month=this.currentMonth;
        this.showYearMonth();
        this.showDate();
    };
    //o {year:2011} or {month:10}
    this.changeShowCalendar=function(o){
        var obj=o;
        if(obj.year){
            if(this.year+obj.year<1990){
                return;
            }
            this.year=this.year+obj.year;
        }
        if(obj.month){
            if(this.month+obj.month>12||this.month+obj.month<1){
                return;
            }
            this.month=this.month+obj.month;
        }
        this.showYearMonth();
        this.showDate();
    };
    this.showYearMonth=function (){
        $("#"+this.calendarIds[0]).html(this.year+"年");
        $("#"+this.calendarIds[1]).html(this.month+"月");
    };
    this.showDate=function(){
        var y = this.year, m = this.month;
        //判断当月有跨越几周
        var week=Math.ceil((new Date(y, m, 0).getDate() + new Date(y, m - 1, 1).getDay()) / 7);
        //当月开始是星期几
        var start_week=new Date(y, m - 1, 1).getDay();
        //当月结束是星期几
        var end_week=new Date(y, m, 0).getDay();
        //当前月有多少天
        var lastDate=new Date(y, m, 0).getDate();

        var tempdate=0,vName=this;
        var parent=getElement(this.calendarIds[2]);
        removeAllNodes(this.calendarIds[2]);
        for(var i=0;i<week;i++){
            var tr=DOC.createElement("tr");
            for(var ii=0;ii<7;ii++){
                var td=DOC.createElement("td");
                td.className="nEasyJsWeekTd";
                tr.appendChild(td);
                if(i==0){
                    if(ii<start_week){
                        continue;
                    }
                }else if(i==(week-1)){
                    if(ii>end_week){
                        continue;
                    }
                }
                tempdate++;
                var tkey=parseInt(""+this.year+(this.month.toString().length>1?this.month:"0"+this.month)+(tempdate.toString().length>1?tempdate:"0"+tempdate));
                if(this.datas.containsKey(tkey)){
                    td.className="sEasyJsWeekTd";
                }
                td.onclick = function(o){vName.chanageDate(this);};//兼容ie6
                td.innerHTML=tempdate;
            }
            parent.appendChild(tr);
        }

    };
    this.GenerateCalender=function(){
        DOC.write('<div id="easyJsCalendarDate" class="easyJsCalendarDate" style="display:none">');
        DOC.write('<div class="easyJsYearMonth"><table width="100%" border="0" cellspacing="1" cellpadding="1"><tr><td onclick="'+this.varName+'.changeYear(-1)">&lt;&lt;</td><td onclick="'+this.varName+'.changeMonth(-1)">&lt;</td><td id="easyJsYear"></td><td id="easyJsMonth"></td><td onclick="'+this.varName+'.changeMonth(1)">&gt;</td><td onclick="'+this.varName+'.changeYear(1)">&gt;&gt;</td></tr></table></div>');
        DOC.write(' <div class="easyJsWeek"><table width="100%" border="0" cellspacing="1" bgcolor="#CCCCCC" cellpadding="1"><tr><th scope="col">日</th><th scope="col">一</th><th scope="col">二</th><th scope="col">三</th><th scope="col">四</th><th scope="col">五</th><th scope="col">六</th></tr><tbody id="easyJsShowDate"></tbody>');
        DOC.write('<tr><td onclick="'+this.varName+'.showToday()" colspan="3">今天</td><td onclick="'+this.varName+'.closeDateWindow()" colspan="3">关闭</td><td onclick="resetCalendarTimeForm()">c</td></tr></table></div></div>');
    };
    this.changeMonth=function(type){
        this.changeShowCalendar({month:type});
    };
    this.changeYear=function(type){
        this.changeShowCalendar({year:type});
    };
    this.showToday=function(){
        this.initShowCalendar();
    };
    this.closeDateWindow=function(){
        $("#easyJsCalendarDate").hide();
    };

    this.setDatasInPage=function(){
        var d=this.datas;
        var s=this.datas.toString(
            function(key,values){
                return values;
            }
        );
        var enter=getElement(this.enter);
        if(enter.nodeName=='INPUT'){
            enter.value=s;
        }else
            enter.innerHTML=s;
    };
    this.clearTimePickerSelect=function(){
        for(var i=0;i<24;i++){
            this.selectTime.splice(i,1,-1);
        }
        var table=getElement("easyJsCalendarTimeTable");
        for(var j=0;j<4;j++){
            var tr=table.rows[j];
            for(var k=0;k<6;k++){
                tr.cells[k].className="cEasyJsCalenderTimeTd";
            }
        }
    };

    this.setStyleProperty=function(o,name,value){
        o.style[name]=value;
    };
    this.chanageDate=function(o){
        this.selectDay=o;
        var tmonth=this.month.toString().length>1?this.month:"0"+this.month,tday=this.selectDay.innerHTML.length>1?this.selectDay.innerHTML:"0"+this.selectDay.innerHTML;
        this.selectKey=parseInt(this.year+""+tmonth+""+tday);
        var selectValue=this.year+"-"+tmonth+"-"+tday;
        if(this.datas.containsKey(this.selectKey)){
            this.selectTime=this.datas.get(this.selectKey);
            this.datas.remove(this.selectKey);
            this.selectDay.className="nEasyJsWeekTd";
        }else{
            this.datas.modify(this.selectKey,selectValue,true);
            this.selectDay.className="sEasyJsWeekTd";
        }
        this.setDatasInPage();
    };

    this.triggerEvent=function(){
        if(this.trigger){
            var t=this;
            $("#"+this.trigger).click(function(e) {
                $("#easyJsCalendarDate").css("position","absolute").css("top", e.pageY+ "px").css("left", e.pageX + "px");
                t.showDatePicker();
            });
        }
    };
    this.showDatePicker=function(id){
        $("#easyJsCalendarDate").show();
    };
    this.putDatas=function(){
        if(this.dataMaps){
            this.dataMaps.put(this.dataKey,this.datas);
        }
    }
    this.setDates=function(key){
        if(!this.dataMaps){
            this.dataMaps=new Map();
        }
        this.dataKey=key;
        if(this.dataMaps.containsKey(key)){
            this.datas=this.dataMaps.get(key);
        }else{
            this.datas=new Map();
        }
    }
    this.GenerateCalender();
    this.init();
    this.initShowCalendar();
    this.triggerEvent();
}