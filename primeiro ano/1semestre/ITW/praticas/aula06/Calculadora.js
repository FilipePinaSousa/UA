function Calcula() {
    var v1 = document.getElementById('num1').value;
    var v2 = document.getElementById('num2').value;
    var op = document.getElementById('op').value;
    var res = document.getElementById('res');
    console.log(op)
    switch (op) {
        case '+':
            res.value = parseFloat(v1) + parseFloat(v2);
            break;
        case '-':
            res.value = parseFloat(v1) - parseFloat(v2);
            break;
        case '/':
            if (v2 == 0) {
                alert("Error! Can't divide by 0")
            } else {
                res.value = parseFloat(v1) / parseFloat(v2);
            }

            break;
        case '*':
            res.value = parseFloat(v1) * parseFloat(v2)
            break
        default:
            alert('Not a valid operation')
            break;
    }
}