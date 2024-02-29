function scrollLeft() {
    document.querySelector('.testimonials-scroll').scrollBy({
        left: -300, // Este valor puede cambiar según el ancho de tus testimonios
        behavior: 'smooth'
    });
}

function scrollRight() {
    document.querySelector('.testimonials-scroll').scrollBy({
        left: 300, // Este valor puede cambiar según el ancho de tus testimonios
        behavior: 'smooth'
    });
}
