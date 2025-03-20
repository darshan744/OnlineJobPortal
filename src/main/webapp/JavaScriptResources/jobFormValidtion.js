function validateForm() {
    const jobRoleInput = document.getElementById('jobRole');
    const jobDescription = document.getElementById('jobDescription');
    const salary = document.getElementById('salary');
    const resultant_skill_set = document.getElementById('resultant-skill-set');
    const jobType = document.getElementById('jobType');
    const location = document.getElementById('location');

    if(checkEmpty(jobRoleInput.value) || checkEmpty(jobDescription.value) || checkEmpty (salary.value) ||checkEmpty (resultant_skill_set.value)|| checkEmpty(jobType.value) || checkEmpty(location.value)){
        return false;
    }
    if(isInvalidSalary(salary.value)){
        console.log(salary.value === 0)
        console.log(salary.value === '0')
        alert('Enter valid Salary amount');
        return false;
    }
    return true;
}

function isInvalidSalary(salary) {
    return salary === "0" || salary === '' || isNaN(salary);
}


function checkEmpty(input) {
    return input === ''
}