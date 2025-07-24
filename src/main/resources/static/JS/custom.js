/***document.addEventListener("DOMContentLoaded", function () {
  const form = document.querySelector('form');
  form.addEventListener('submit', function () {
    const overlay = document.getElementById('spinner-overlay');
    if (overlay) {
      overlay.style.display = 'flex';
    }

    document.getElementById("submitBtn").disabled = true;
    document.getElementById("btnText").textContent = "Sending...";
    document.getElementById("spinner").classList.remove("d-none");
  });

  const urlParams = new URLSearchParams(window.location.search);
  if (urlParams.get('success')) {
    const contactSection = document.getElementById('contact');
    if (contactSection) {
      contactSection.scrollIntoView({ behavior: 'smooth' });
    }
  }
});
***/