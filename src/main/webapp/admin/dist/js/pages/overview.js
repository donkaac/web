function loadAll() {
    $.ajax({
        url: REST_PATH + "/overview",
        type: "get",
        success: function (data) {
            let data_set = "";
            for (let i of data) {
                data_set += `<tr>
                     <td>${i.title}</td>
                     <td>${i.subtitle}</td>
                    <td></td>
                    <td>${i.link}</td>
                    <td></td>
                    <td></td>
                    </tr>`
            }

            $("#overview-all").html(data_set);
        },
        error: function (error) {
            //  console.log(error);
        }
    });
}