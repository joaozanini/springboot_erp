fetch("http://localhost:8080/clientes", {
    headers: {
        "Authorization": "Bearer " + localStorage.getItem("token")
    }
})
    .then(res => {
        if (!res.ok) {
            if (res.status === 401) {
                alert("Sessão expirada. Faça login novamente.");
                window.location.href = "index.html";
            }
            throw new Error("Erro ao buscar clientes");
        }
        return res.json();
    })
    .then(clientes => {
        // renderiza os clientes
        console.log(clientes);
    })
    .catch(err => {
        console.error(err.message);
    });