document.getElementById("registerForm").addEventListener("submit", function(event) {

    event.preventDefault();

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        course: document.getElementById("course").value,
        year: parseInt(document.getElementById("year").value)
    };

    fetch("/api/students/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
        .then(response => response.json())
        .then(data => {

            document.getElementById("message").textContent =
                "Registration successful! Welcome to StudentSphere, " + data.name;

            document.getElementById("registerForm").reset();

        })
        .catch(error => {

            document.getElementById("message").textContent =
                "Registration failed. Please try again.";

            console.error(error);
        });

});