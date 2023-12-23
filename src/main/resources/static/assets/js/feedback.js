var stars = document.querySelectorAll('.star');
function setStarRating(starIndex) {
    stars.forEach((star, index) => {
        star.style.color = index <= starIndex ? 'yellow' : 'white';
        star.style.borderColor = 'yellow';
    });
}
