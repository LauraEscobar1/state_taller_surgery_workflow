const API = "http://localhost:8080/api/surgery";

async function getState() {
    const res = await fetch(`${API}/state`);
    const text = await res.text();

    document.getElementById("state").innerText = text;

    updateColor(text);
}

async function nextStep() {
    const res = await fetch(`${API}/next`);
    const text = await res.text();

    document.getElementById("state").innerText = text;

    updateColor(text);
}

function updateColor(state) {
    const card = document.getElementById("card");

    card.className = "card"; // reset

    if (state.includes("Registered")) card.classList.add("registered");
    else if (state.includes("Evaluated")) card.classList.add("evaluated");
    else if (state.includes("Pre")) card.classList.add("preop");
    else if (state.includes("Surgery")) card.classList.add("surgery");
    else if (state.includes("Recovery")) card.classList.add("recovery");
    else if (state.includes("Discharged")) card.classList.add("discharged");
}

// cargar estado inicial
getState();