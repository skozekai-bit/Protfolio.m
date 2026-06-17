document.addEventListener("DOMContentLoaded", () => {
    const filePicker = document.getElementById('master-file-picker');
    const triggers = document.querySelectorAll('.upload-trigger');
    let activeTargetImg = null;

    // Open your system file browser when clicking layout blocks
    triggers.forEach(trigger => {
        trigger.addEventListener('click', () => {
            const targetId = trigger.getAttribute('data-target');
            activeTargetImg = document.getElementById(targetId);
            filePicker.click();
        });
    });

    // Accept locally processed images to personalize your site preview dynamically
    filePicker.addEventListener('change', (event) => {
        const file = event.target.files[0];
        if (file && activeTargetImg) {
            const reader = new FileReader();
            
            reader.onload = function(e) {
                activeTargetImg.src = e.target.result;
                
                // Keep default placeholder behaviors intact if needed
                const parent = activeTargetImg.parentElement;
                const placeholder = parent.querySelector('.upload-placeholder, .ticket-placeholder-text');
                if (placeholder) {
                    placeholder.style.opacity = '0';
                }
            };
            
            reader.readAsDataURL(file);
        }
    });
});

