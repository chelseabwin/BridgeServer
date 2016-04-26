/*****************************************************************
                  jQuery Ajax��װͨ����  
*****************************************************************/
$(function(){
    /**
     * ajax��װ
     * url ��������ĵ�ַ
     * data ���͵������������ݣ�����洢���磺{"date": new Date().getTime(), "state": 1}
     * async Ĭ��ֵ: true��Ĭ�������£����������Ϊ�첽���������Ҫ����ͬ�������뽫��ѡ������Ϊ false��
     *       ע�⣬ͬ��������ס��������û�������������ȴ�������ɲſ���ִ�С�
     * type ����ʽ("POST" �� "GET")�� Ĭ��Ϊ "GET"
     * dataType Ԥ�ڷ��������ص��������ͣ����õ��磺xml��html��json��text
     * successfn �ɹ��ص�����
     * errorfn ʧ�ܻص�����
     */
    jQuery.ax=function(url, data, async, type, dataType, successfn, errorfn) {
        async = (async==null || async=="" || typeof(async)=="undefined")? "true" : async;
        type = (type==null || type=="" || typeof(type)=="undefined")? "post" : type;
        dataType = (dataType==null || dataType=="" || typeof(dataType)=="undefined")? "json" : dataType;
        data = (data==null || data=="" || typeof(data)=="undefined")? {"date": new Date().getTime()} : data;
        $.ajax({
            type: type,
            async: async,
            data: data,
            url: url,
            dataType: dataType,
            success: function(d){
                successfn(d);
            },
            error: function(e){
                errorfn(e);
            }
        });
    };
    
    /**
     * ajax��װ
     * url ��������ĵ�ַ
     * data ���͵������������ݣ�����洢���磺{"date": new Date().getTime(), "state": 1}
     * successfn �ɹ��ص�����
     */
    jQuery.axs=function(url, data, successfn) {
        data = (data==null || data=="" || typeof(data)=="undefined")? {"date": new Date().getTime()} : data;
        $.ajax({
            type: "post",
            data: data,
            url: url,
            success: function(d){
                successfn(d);
            }
        });
    };
    
    /**
     * ajax��װ
     * url ��������ĵ�ַ
     * data ���͵������������ݣ�����洢���磺{"date": new Date().getTime(), "state": 1}
     * dataType Ԥ�ڷ��������ص��������ͣ����õ��磺xml��html��json��text
     * successfn �ɹ��ص�����
     * errorfn ʧ�ܻص�����
     */
    jQuery.axse=function(url, data, successfn, errorfn) {
        data = (data==null || data=="" || typeof(data)=="undefined")? {"date": new Date().getTime()} : data;
        $.ajax({
            type: "post",
            data: data,
            url: url,
            dataType: "json",
            success: function(d){
                successfn(d);
            },
            error: function(e){
                errorfn(e);
            }
        });
    };



});