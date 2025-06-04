fetch("http://localhost:8080/produtos", {
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
            throw new Error("Erro ao buscar produtos");
        }
        return res.json();
    })
    .then(produtos => {
        // renderiza as produtos
        console.log(produtos);
    })
    .catch(err => {
        console.error(err.message);
    });