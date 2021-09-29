document.addEventListener("DOMContentLoaded", () => {
    let selects = document.querySelectorAll("select");
    for (const select of selects) {
        initSelectedOption(select);
    }
    M.FormSelect.init(selects);

    const datePickers = document.querySelectorAll('.datepicker');
    for (const datePicker of datePickers) {
        const [year, month, day] = datePicker.value.split("-");
        M.Datepicker.init(datePicker, {
            defaultDate: new Date(year, month, day),
            format: "yyyy-mm-dd"
        });
    }
});

function initSelectedOption(select) {
    const value = select.getAttribute("value");
    if (value == null) {
        return;
    }
    let option = select.querySelector(`option[value='${value.toLowerCase()}']`);
    if (option == null) {
        option = select.querySelector("option");
    }
    if (option != null) {
        option.setAttribute("selected", "selected");
    }
}