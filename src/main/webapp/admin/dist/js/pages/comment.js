function loadAll() {
    $.ajax({
        url : REST_PATH + "/comment",
        type : "get",
        source : function (data) {
            let data_set="";
            for(let i of data){
                data_set += `<tr>
                <td>${i.name}</td>
                <td>${i.date}</td>
                <td>${i.name}</td>
                </tr>`
            }
            $("#comments-all").html(data_set);
        },

        err : function () {

        }
    })
}



