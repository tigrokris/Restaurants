var form;



function makeEditable() {
    form = $('#detailsForm');

    form.submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
}
var showButton=new Boolean(true);
function isVoted(){
   $.ajax({
       url: 'ajax/profile/dishes/dateOfVote',
       type: 'GET',
       async: false,
       success: function (data) {
           var dateObject = new Date(data);
           var today = new Date();
           showButton = Boolean( (dateObject.getDate() - today.getDate()) != 0 );
       }
   });
    return showButton;
}


function add() {
    form.find(":input").val("");
    $('#id').val(0);
    if(document.getElementById('restaurantSelect')) {
        var data;
        propagateSelect(data);
    }
    $('#editRow').modal();
}
function updateRow(id) {
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("[name='" + key + "']").val(value);
            if(key =='restaurant'){
                propagateSelect(data);
            }
        });
        $('#editRow').modal();
    });
}
function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function vote(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'PUT',
        success: function () {
            //updateTable();
            successNoty('Voted');
            window.location.href = "restaurantsList";
        }
    });
}
function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize(),
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>" + errorInfo.cause + "<br>" + errorInfo.detail,
        type: 'error',
        layout: 'bottomRight'
    });
}

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ');">Edit</a>';
    }
    return data;
}

function renderVoteBtn(data, type, row) {
   if (type == 'display' ) {
        return '<a class="btn btn-xs btn-primary" onclick="vote(' + row.id +');">Vote</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display' ) {
         return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ');">Delete</a>';
    }
    return data;
}