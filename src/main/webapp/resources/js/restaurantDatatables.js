var ajaxUrl = 'ajax/profile/restaurantsList/';
var datatableApi;
var datatableUserApi;

function updateTable() {
    $.get(ajaxUrl, function (data) {
        updateTableByData(data);
    });
}

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "votes"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn

            }

        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],

        "initComplete": makeEditable
    });
});
$(function () {
    datatableUserApi = $('#datatableUser').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "votes"
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],

        "initComplete": makeEditable
    });
});