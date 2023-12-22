
$(document).ready(function(){
    function setColorBasedOnStatus(statusElement, status) {
        var color = getColorForStatus(status);
        statusElement.css('color', color);
    }
    function addOptionWithColor(statusSelect, optionText, optionValue) {
        var option = new Option(optionText, optionValue);
        $(option).css('color', getColorForStatus(optionValue));
        statusSelect.append(option);
    }
    function getColorForStatus(status) {
        switch(status) {
            case 'not confirmed': return '#FFA500';
            case 'awaiting delivery': return '#FFD700';
            case 'cancelled': return '#FF4500';
            case 'in progress': return '#0000FF';
            case 'completed': return '#008000';
            case 'undeliverable': return '#FF69B4';
            default: return 'black';
        }
    }
    function initializeOptions(statusSelect) {
        statusSelect.empty();
        addOptionWithColor(statusSelect, 'Not Confirmed', 'not confirmed');
        addOptionWithColor(statusSelect, 'Awaiting Delivery', 'awaiting delivery');
        addOptionWithColor(statusSelect, 'Cancelled', 'cancelled');
    }
    function updateOptions(statusSelect, currentStatus) {
        if(currentStatus === 'awaiting delivery') {
            statusSelect.empty();
            addOptionWithColor(statusSelect, 'Awaiting Delivery', 'awaiting delivery');
            addOptionWithColor(statusSelect, 'In Progress', 'in progress');
            addOptionWithColor(statusSelect, 'Cancelled', 'cancelled');
        } else if(currentStatus === 'in progress') {
            statusSelect.empty();
            addOptionWithColor(statusSelect, 'In Progress', 'in progress');
            addOptionWithColor(statusSelect, 'Completed', 'completed');
            addOptionWithColor(statusSelect, 'Undeliverable', 'undeliverable');
        } else if(['not confirmed', 'cancelled', 'completed', 'undeliverable'].includes(currentStatus)) {
        }
        setColorBasedOnStatus(statusSelect, currentStatus);
    }

    $('.statusSelect').each(function() {
        var currentStatus = $(this).val();
        initializeOptions($(this));
        setColorBasedOnStatus($(this), currentStatus);
    });

    $('.btn-update').click(function(){
        var statusSelect = $(this).closest('tr').find('.statusSelect');
        var currentStatus = statusSelect.val();
        updateOptions(statusSelect, currentStatus);
    });

    $('.statusSelect').change(function(){
        var selectedStatus = $(this).val();
        setColorBasedOnStatus($(this), selectedStatus);
    });
});


