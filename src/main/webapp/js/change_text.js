function change_on_bought(elementId) {
    var p = document.getElementById(elementId);

    if (p.value === "buy")
        p.value = "you got it";
    else
        p.value = "buy";
}
