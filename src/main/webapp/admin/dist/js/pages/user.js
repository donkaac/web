function loadAll() {
    $.ajax({
        url: REST_PATH + "/user",
        type: "get",
        success: function (data) {
            let data_set = "";
            for (let i of data) {
                data_set += `<tr>
                     <td>${i.name}</td>
                     <td>${i.email}</td>
                    </tr>`
            }
            $("#user-all").html(data_set);
        },
        error: function (error) {
            //  console.log(error);
        }
    });
}