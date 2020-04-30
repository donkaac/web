function loadAll() {
    $.ajax({
        url : REST_PATH + "/comment",
        type : "get",
        success : function (data) {
            console.log("OK")
            let data_set="";
            for(let i of data){
                data_set += `<tr>
                <td>${i.name}</td>
                <td>${i.date}</td>
                <td>${i.comment}</td>
                </tr>`
            }
            $("#comments-all").html(data_set);
        },

        error : function () {
            console.log("error")
        }
    })
}



