/**
 * 
 * @param inputelement id {id -> string}
 * @description changes the disabled field of the input element 
 */
function openEditOption(id){
    const inputElement = document.getElementById(id);
    inputElement.disabled  = !inputElement.disabled
}

