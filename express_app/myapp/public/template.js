
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


function update(){
	let output = document.getElementById("selectDegree").value;
	const container = document.getElementById("templateArea");
	container.innerHTML = "";

	let x = 0;
	if(output == 'CSE'){
		fetch('./CSEDegree.txt').then( response=>  {
			classes = response.text().then( function (mydata){
				const res = mydata.split(/\r?\n/);
				console.log(res);

				for(let i = 0; i < res.length-1; i++){
					if(res[i] === ''){
						let h3 = document.createElement("h3");
						let node = document.createTextNode(Labels[x]);
						h3.appendChild(node);
						container.appendChild(h3);
						x++;
						continue;
					}
					let li = document.createElement("li");
					let node = document.createTextNode(res[i]);
					li.appendChild(node);
					container.appendChild(li);
				}
			})
		})
	} else if(output == 'CPEG'){
		fetch('./CPEGDegree.txt').then( response=>  {
			console.log("reading CPEGDEGREE!");
			classes = response.text().then(function (mydata){
				const res = mydata.split(/\r?\n/);
				console.log(res);
				
				for(let i = 0; i < res.length-1; i++){
					if(res[i] === ''){
						let h3 = document.createElement("h3");
						let node = document.createTextNode(Labels[x]);
						h3.appendChild(node);
						container.appendChild(h3);
						x++;
						continue;
					}
					let li = document.createElement("li");
					let node = document.createTextNode(res[i]);
					li.appendChild(node);
					container.appendChild(li);
				}
			})
		})
	} else if(output == 'EE'){
		fetch('./EEDegree.txt').then( response=>  {
			console.log("reading EEDEGREE!");
			classes = response.text().then(function(mydata){
				const res = mydata.split(/\r?\n/);
				console.log(res);

				for(let i = 0; i < res.length-1; i++){
					if(res[i] === ''){
						let h3 = document.createElement("h3");
						let node = document.createTextNode(Labels[x]);
						h3.appendChild(node);
						container.appendChild(h3);
						x++;
						continue;
					}
					let li = document.createElement("li");
					let node = document.createTextNode(res[i]);
					li.appendChild(node);
					container.appendChild(li);
				}
			})
		})
	}
}


//ument.getElementById('templateArea').appendChild('')
const para = document.createElement('p');
para.id = "output"
//para.innerText = "Test text";
document.body.appendChild(para);

document.getElementById('templateArea').appendChild(ul);
let i = 0;

let value = document.querySelector('#selectDegree').value;
console.log(value);

let classes = []
const container = document.getElementById("templateArea");
        
  /*
Tclasses.forEach(function (item) {
    let header = document.createElement('h3');
    header.innerHTML = Labels[i];
    ul.appendChild(header);

    let li = document.createElement('li');
    ul.appendChild(li);

    li.innerHTML += item;
    i += 1;
});
console.log("reading CSEDegree.txt");
*/


