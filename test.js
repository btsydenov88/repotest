function addNumbers() {
    // Get the values of the input fields
    var num1 = parseInt(document.getElementById("num1").value);
    var num2 = parseInt(document.getElementById("num2").value);

    // Add the numbers together
    var result = num1 + num2;

    // Update the result field with the answer
    document.getElementById("result").innerHTML = result;
}
