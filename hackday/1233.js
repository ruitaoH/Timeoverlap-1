/*
 * Map对象，实现Map功能
 *
 *
 * size() 获取Map元素个数
 * isEmpty() 判断Map是否为空
 * clear() 删除Map所有元素
 * put(key, value) 向Map中增加元素（key, value)
 * remove(key) 删除指定key的元素，并返回该key的value
 * get(key) 获取指定key的元素值value
 * modify(key,value,auto) 修改key的value.如果auto为true,key不存在,会将key和value添加为新值;为false,key不存在将不进行添加
 * containsKey(key) 判断Map中是否含有指定key的元素
 * containsValue(value) 判断Map中是否含有指定value的元素
 * keys() 获取Map中所有key的数组（array）
 * values() 获取Map中所有value的数组（array）
 *
 */



function Map(){
    /**
     *初始化datas
     */
    this.initialize=function(){
        this.datas=new Object();
    }

    /**
     * 得到datas中的对象数目
     */
    this.size=function() {
        var i = 0;
        for(var ele in this.datas) {
            i ++;
        }
        return i;
    };
    this.isEmpty=function(){
        return this.size()>0?false:true;
    };
    this.clear=function(){
        for(var key in this.datas) {
            delete this.datas[key];
        }
    };
    this.put=function(key, value) {
        return this.datas[key] = value;
    }
    this.remove=function(key) {
        var value = this.datas[key];
        delete this.datas[key];
        return value;
    };
    this.get=function(key) {
        if (this.datas[key] !== Object.prototype[key])
            return this.datas[key];
    };
    this.modify=function(key,value,auto){
        if(this.containsKey(key)){
            this.remove(key);
            this.put(key,value);
        }else{
            if(auto){
                this.put(key,value);
            }
        }
    };
    this.containsKey=function(key){
        if(key in this.datas){
            return true;
        }
        return false;
    };
    this.containsValue=function(value){
        var r=false;
        for(var key in this.datas){
            if(this.datas[key]==value){
                r=true;
                break;
            }
        }
        return r;
    }
    this.keys=function() {
        return this.pluck('key');
    };
    this.values=function() {
        return this.pluck('value');
    };

    /**
     * 遍历Map,执行处理函数
     * @param {Function} 回调函数 function(arrary){..}
     */
    this.each=function(fn){
        for (var key in this.object) {
            var value = this.object[key], pair = [key, value];
            pair.key = key;
            pair.value = value;
            fn(pair);
        }
    };

    /**
     * 返回object的对象的复制
     */
    this.toObject=function(){
        var destination={};
        for (var property in this.datas)
            destination[property] = this.datas[property];
        return destination;
    };

    this.pluck=function(property) {
        var results = [];
        for(var key in this.datas){
            if(property=='key'){
                results.push(key);
            }else if(property=='value'){
                results.push(this.datas[key]);
            }
        }
        return results;
    };




    /**
     * toString方法
     * fn是调用函数
     */
    this.toString=function(fn) {
        var b = this.datas;
        var buf = [];
        for(var key in b) {
            buf.push(fn(key,b[key]));
            buf.push('\n');
        }
        return buf.join('');
    };

    this.formatToString=function(fn){
        var keys=this.keys();
        //function sortNumber(a,b){return a - b} 从小到大 ；function sortNumber(a,b){return b - a} 从大到小
        keys.sort(function sortNumber(a,b){return a - b});
        var buf=[];
        for(var i=0;i<keys.length;i++){
            buf.push(fn(keys[i],this.datas[keys[i]]));
            buf.push("\n");
        }
        return buf.join('');
    };

    this.initialize();
}

function StringBuffer(){

    this.array=[];
    this.append=function(string){
        this.array.push(string);
    }
    this.toString=function(){
        return this.array.join("");
    }
}
//删除该id下的所有节点
function removeAllNodes(id){
    var parent=document.getElementById(id);
    while(parent.childNodes.length>0) {
        parent.removeChild(parent.childNodes[0]);
    }
}