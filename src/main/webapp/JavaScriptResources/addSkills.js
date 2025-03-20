let selectedSkill = []

function addSkill() {
   //getting the entered input element
   const skillInput = document.getElementById('skill-input');
   // input element value
   const skill =  skillInput.value.trimStart().trimEnd();
   //checking if already exist
    const doesExist = selectedSkill.includes(skill)
    if(skill && !doesExist) {
        //if not push into array
        selectedSkill.push(skill);
    }
    // render the new array
    renderSkillSet();
    //reset the value
    skillInput.value = '';
    //add to the input element that will be handled in servlet
    addToInput();
}
function renderSkillSet() {
    //container for rendering the list
    const skillShowContainer = document.getElementById("skill-show-container");
    //resetting the container
    skillShowContainer.innerHTML = '';
    for(let skill of selectedSkill) {
        //bootstrap badge for chipd like tag
        const chip = document.createElement('div');
        chip.innerHTML = `<div class="btn btn-light btn-sm">${skill}
                                <span class="ms-2" onclick="removeSkill('${skill}')" aria-hidden="true">&times;</span>
                          </div>`
        skillShowContainer.appendChild(chip);
    }
}

function addToInput() {
   const inputElement = document.getElementById('resultant-skill-set');
   console.log(inputElement)
    //joining the array as a single string
   const skillvalues = selectedSkill.join(',');
    //setting to the resultant value
   inputElement.value = skillvalues;
   
}

function removeSkill(skillName){
    selectedSkill = selectedSkill.filter(skill => skill !== skillName);
    renderSkillSet();
    addToInput();
}
