
if (10 == 10){
    alert("working!");
}

let items = [
        'Blue',
        'Red',
        'White',
        'Green',
        'Black',
        'Orange'
    ],
    ul = document.createElement('ul');

document.getElementByName('templateArea').appendChild(ul);

items.forEach(function (item) {
    let li = document.createElement('li');
    ul.appendChild(li);

    li.innerHTML += item;
});
