const API = "http://localhost:8080/api/surgery";

async function getState() {
    const res = await fetch(`${API}/state`);
    const text = await res.text();
    document.getElementById("state").innerText = text;
}

async function nextStep() {
    const res = await fetch(`${API}/next`, { method: "POST" });
    const text = await res.text();
    document.getElementById("state").innerText = text;
}

getState();