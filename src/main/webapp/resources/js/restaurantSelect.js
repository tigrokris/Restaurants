/**
 * Created by Dmitriy on 26.02.2017.
 */
var ajaxUrlRestaurants = 'ajax/profile/restaurantsList/';
var restaurantSelect = $('#restaurantSelect');
var restaurantsArray = [];
/*$('#editRow').on('show.bs.modal', function () {
    $.ajax({
            type: 'GET',
            url: ajaxUrlRestaurants,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function (data) {
                restaurantSelect.empty();
                $.each(data, function (i, obj) {
                    restaurantsArray[i] = obj;
                });
            }
        }
    );
    restaurantSelect.empty();
    for (var i = 0; i < restaurantsArray.length; i++) {
        restaurantSelect.append($("<option></option>").val(restaurantsArray[i].id).html(restaurantsArray[i].name));
    }

    for (var i = 0; i < restaurantsArray.length; i++) {
        if (data != undefined && restaurantsArray[i].id == data.restaurant.id) {
            restaurantSelect.val(data.restaurant.id);
            break;
        }
        restaurantSelect.val(restaurantsArray[0].id);
    }
    $('#restaurantId').val(restaurantSelect.val());
});*/
restaurantSelect.click(function () {
    $('#restaurantId').val(restaurantSelect.val());
})
function propagateSelect(data) {
    $.ajax({
            type: 'GET',
            url: ajaxUrlRestaurants,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function (data) {
                restaurantSelect.empty();
                $.each(data, function (i, obj) {
                    restaurantsArray[i] = obj;
                });
            }
        }
    );
    restaurantSelect.empty();
    for (var i = 0; i < restaurantsArray.length; i++) {
        restaurantSelect.append($("<option></option>").val(restaurantsArray[i].id).html(restaurantsArray[i].name));
    }

    for (var i = 0; i < restaurantsArray.length; i++) {
        if (data != undefined && restaurantsArray[i].id == data.restaurant.id) {
            restaurantSelect.val(data.restaurant.id);
            break;
        }
        restaurantSelect.val(restaurantsArray[0].id);
    }
    $('#restaurantId').val(restaurantSelect.val());
}

