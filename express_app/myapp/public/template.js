

let Tclasses = [
        ['University Core Requirement', 'Engineering Design', 'Intro to Chemical Principles', 'Calculus 1', 'Moreau FYS'],['University Core Requirement', 
    'Engineering Computing', 'Moreau FYS', 'Calculus 2', 'Physics 1'], 
    ['University Core requirement', 'Discrete Mathematics', 'Fundamental Computing', 'Calculus 3', 'Physics 2'],
    ['University Core Requirement', 'Logic Design', 'Systems Programming', 'Data Structures', 'Linear Algebra and Diffeq'],
    ['University Core requirement', 'CSE Elective', 'CSE Elective', 'Computer Architecture', 'Tech Elective'],
    ['University Core requirement','Theory of Computing', 'Programming Paradigms', 'Operating Systems', 'Probability and Statistics'],
    ['CSE Elective', 'CSE ELective', 'Free Elective', 'Algorithms'],
    ['University Core requirement','CSE Elective', 'CSE Elective', 'Ethical and Professional Issues' ],
]   

let Labels = ['Freshman Fall', 'Freshman Spring','Sophomore Fall', 'Sophomore Spring', 'Junior Fall', 'Junior Spring', 'Senior Fall', 'Senior Spring'];
    ul = document.createElement('ul');

//ument.getElementById('templateArea').appendChild('')
const para = document.createElement('p');
para.innerText = "Test text";
document.body.appendChild(para);

document.getElementById('templateArea').appendChild(ul);
let i = 0;

Tclasses.forEach(function (item) {
    let header = document.createElement('h3');
    header.innerHTML = Labels[i];
    ul.appendChild(header);

    let li = document.createElement('li');
    ul.appendChild(li);

    li.innerHTML += item;
    i += 1;
});

let value = document.querySelector('#selectDegree').value;
console.log(value);

fetch('./CSEDegree.txt');

