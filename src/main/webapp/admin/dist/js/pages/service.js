function  loadAll() {
    $.ajax({
        url : REST_PATH + "/services",
        type : "get",
        success : function (data) {
            let data_set="";
            for (let i of data){
                data_set += `<tr>
                    <td>${i.name}</td>
                    <td>${i.content}</td>
                   
                </tr>`
            }
            $("#service-provider-all").html(data_set);
        },
        err: function () {

        }
    })
}