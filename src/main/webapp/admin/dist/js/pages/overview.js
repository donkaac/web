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


function loadTopics(){
    $.ajax({
        url: REST_PATH + "/overview",
        type: "get",
        success : function (data) {
            let data_set="";
            for(let i of data){
                data_set +=`<tr>
                <td>${i.title}</td>
                <td>${i.subtitle}</td>
                <td><a href="" class="btn btn-xs btn-default"><i class="fa fa-edit"></i> Edit</a>
                <a href="" class="btn btn-xs btn-default"><i class="fa fa-trash"></i> Delete</a></td>
                </tr>`
            }
            $("#overview-all-titles").html(data_set);
        },
        error : function () {

        }
    });
}

function loadTopicsToAddContent() {
    $.ajax({
        url: REST_PATH + "/overview",
        type: "get",
        success: function (data) {
            let data_set = "";
            for (let i of data) {
                data_set += `<option>${i.title}</option>`
            }

            $("#overview-all-to-sub-topic").html(data_set);
        },
        error: function (error) {
            //  console.log(error);
        }
    });
}