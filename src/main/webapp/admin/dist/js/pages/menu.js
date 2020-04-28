function  loadAll() {
    $.ajax({

        url : REST_PATH + "/menu",
        type : "get",
        success : function (data) {
            let data_set="";
            for(let i of data){
                data_set +=`<tr>
                <td>${i.name}</td>
                </tr>`
            }
            $("#menu-all").html(data_set);
        },
        error : function () {

        }
    });
}