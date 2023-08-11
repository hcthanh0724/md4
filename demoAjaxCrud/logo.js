const html = document.querySelector('html');
const logo = document.querySelector('.logo');
const text = document.querySelector('h1');

html.addEventListener('click', () => {
    logo.style.webkitAnimation = 'none';
    text.style.webkitAnimation = 'none';
    setTimeout(function() {
        logo.style.webkitAnimation = '';
        text.style.webkitAnimation = '';
    }, 10);
});