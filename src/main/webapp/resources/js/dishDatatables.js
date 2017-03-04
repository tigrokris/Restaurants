var ajaxUrl = 'ajax/profile/dishes/';
var datatableApi;
var datatableUserApi;

function updateTable() {
    $.get(ajaxUrl, function (data) {
        updateTableByData(data);
    });
}
//table for AdminRole
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
                "data": "price"
            },
            {
                "data": "restaurant.name"
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
//table for UserRole
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
                "data": "price"
            },
            {
                "data": "restaurant.name"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "visible":isVoted(),
                "render": renderVoteBtn
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