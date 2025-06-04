async function login() {
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    const resposta = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, senha }),
    });

    const data = await resposta.json();

    if (resposta.ok) {
        localStorage.setItem("token", data.token);
        window.location.href = "dashboard.html";
    } else {
        alert("Email ou senha inválidos");
    }
}