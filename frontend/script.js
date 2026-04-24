const API = "http://localhost:8080/api/surgery";

// Mapeo de estados a iconos y textos
const stateConfig = {
    "Registered": { icon: "edit_note", label: "Registrado", step: 0 },
    "Evaluated": { icon: "search", label: "Evaluado", step: 1 },
    "Pre-Operative": { icon: "biotech", label: "Pre-Operatorio", step: 2 },
    "Surgery": { icon: "medical_services", label: "En Cirugía", step: 3 },
    "Recovery": { icon: "favorite", label: "En Recuperación", step: 4 },
    "Discharged": { icon: "check_circle", label: "Alta Médica", step: 5 }
};

async function getState() {
    try {
        const res = await fetch(`${API}/state`);
        const text = await res.text();
        updateUI(text);
    } catch (e) {
        document.getElementById("state").innerText = "Conectando...";
    }
}

async function nextStep() {
    try {
        const res = await fetch(`${API}/next`);
        const text = await res.text();
        updateUI(text);
    } catch (e) {
        console.error("Error:", e);
    }
}

function updateUI(state) {
    // Actualizar texto principal
    document.getElementById("state").innerText = state;

    // Buscar configuración del estado
    let config = null;
    for (const key in stateConfig) {
        if (state.includes(key)) {
            config = stateConfig[key];
            break;
        }
    }

    // Actualizar icono y chip
    const iconEl = document.getElementById("stateIcon");
    const chipText = document.getElementById("chipText");
    const card = document.getElementById("card");

    if (config) {
        iconEl.innerText = config.icon;
        chipText.innerText = config.label;
        updateTimeline(config.step);
    } else {
        iconEl.innerText = "pending";
        chipText.innerText = state;
    }

    // Actualizar clase del card
    card.className = "google-card";
    if (state.includes("Registered")) card.classList.add("registered");
    else if (state.includes("Evaluated")) card.classList.add("evaluated");
    else if (state.includes("Pre")) card.classList.add("preop");
    else if (state.includes("Surgery")) card.classList.add("surgery");
    else if (state.includes("Recovery")) card.classList.add("recovery");
    else if (state.includes("Discharged")) card.classList.add("discharged");
}

function updateTimeline(currentStep) {
    const steps = document.querySelectorAll(".timeline-step");
    
    steps.forEach((step, index) => {
        step.classList.remove("active", "completed");
        
        if (index < currentStep) {
            step.classList.add("completed");
        } else if (index === currentStep) {
            step.classList.add("active");
        }
    });
}

// Cargar estado inicial
getState();