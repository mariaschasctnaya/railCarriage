$(function() {

    $('#tickets').dataTable({
        "sDom": "<'row'<'span4'l><'span4 search_table'f>r>t<'row'<'span4'i><'span4 offset4'p>>",
        "sPaginationType": "bootstrap",
        "oLanguage": {
            "sLengthMenu": "_MENU_ records per page"
        },
        "sAjaxSource": 'ticket',
        "sServerMethod": "GET",
        "sAjaxDataProp" : "",
        "columnDefs": [
            {
                "mData": "trainNumber",
                "targets": 0
            },
            {
                "mData": "passenger",
                "render": function ( data, type, row ) {
                    return data.name + '   ' + data.surname + '  ' +data.birthday;
                },
                "targets": 1
            },
            {
                "mData": "station",
                "targets": 2
            }

        ]
    });


});