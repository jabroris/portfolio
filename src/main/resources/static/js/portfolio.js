/* ===== API DEMO ===== */
const I18N = window.PORTFOLIO_I18N || {};

function t(key, fallback) {
    const value = I18N[key];
    return value === undefined || value === null ? fallback : value;
}

function tf(key, fallback, ...args) {
    const template = t(key, fallback);
    return template.replace(/\{(\d+)}/g, (_, index) => String(args[Number(index)] ?? ""));
}

async function loadExperiences() {
    const output = document.getElementById('api-result');
    output.textContent = t('apiLoading', '// Loading...');
    try {
        const res = await fetch('/api/experiences');
        const data = await res.json();
        output.textContent = JSON.stringify(data, null, 2);
    } catch (e) {
        output.textContent = '// Error: ' + e.message;
    }
}

async function searchByTech() {
    const tech = document.getElementById('techSearch').value.trim();
    if (!tech) { alert(t('enterTechnology', 'Please enter a technology name')); return; }
    const output = document.getElementById('api-result');
    output.textContent = tf('searchingFor', '// Searching for experiences with: "{0}"...', tech);
    try {
        const res = await fetch(`/api/experiences/search?technology=${encodeURIComponent(tech)}`);
        const data = await res.json();
        output.textContent = data.length
            ? JSON.stringify(data, null, 2)
            : tf('noExperiencesFound', '// No experiences found with technology: "{0}"', tech);
    } catch (e) {
        output.textContent = '// Error: ' + e.message;
    }
}

/* ===== KAFKA DEMO ===== */

async function publishKafkaEvent() {
    const message = document.getElementById('kafkaMessage').value.trim();
    if (!message) { alert(t('enterMessage', 'Please enter a message')); return; }

    const statusEl = document.getElementById('kafka-status');
    statusEl.className = 'status-msg';
    statusEl.textContent = '';

    try {
        const res = await fetch('/api/events/publish', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ message })
        });
        const data = await res.json();
        const result = data.result || '';

        if (result.includes('KAFKA_UNAVAILABLE') || result.includes('unavailable')) {
            statusEl.className = 'status-msg warning';
            statusEl.textContent = `${t('statusWarningPrefix', '⚠️')} ${result}`;
        } else {
            statusEl.className = 'status-msg success';
            statusEl.textContent = `${t('statusSuccessPrefix', '✅')} ${result}`;
        }

        // Refresh event log after a short delay (consumer may need a moment)
        setTimeout(loadKafkaEvents, 800);
    } catch (e) {
        statusEl.className = 'status-msg error';
        statusEl.textContent = `${t('statusErrorPrefix', '❌ Error:')} ${e.message}`;
    }
}

async function loadKafkaEvents() {
    const tbody = document.getElementById('kafka-event-body');
    try {
        const res = await fetch('/api/events');
        const events = await res.json();

        if (!events.length) {
            tbody.innerHTML = `<tr><td colspan="5" class="empty-row">${t('kafkaEmpty', 'No events yet. Publish a message above.')}</td></tr>`;
            return;
        }

        tbody.innerHTML = events.map((e, i) => `
            <tr>
                <td>${e.id}</td>
                <td class="direction-${e.direction.toLowerCase()}">${e.direction}</td>
                <td>${escapeHtml(e.message)}</td>
                <td class="${e.status === 'OK' ? 'status-ok' : 'status-unavailable'}">${e.status}</td>
                <td>${e.timestamp}</td>
            </tr>
        `).join('');
    } catch (err) {
        tbody.innerHTML = `<tr><td colspan="5" class="empty-row">${tf('kafkaErrorLoading', 'Error loading events: {0}', err.message)}</td></tr>`;
    }
}

/* ===== ACTUATOR DEMO ===== */

async function loadActuatorHealth() {
    const output = document.getElementById('actuator-result');
    output.textContent = t('actuatorLoadingHealth', '// Loading health data...');
    try {
        const res = await fetch('/actuator/health');
        const data = await res.json();
        output.textContent = JSON.stringify(data, null, 2);
    } catch (e) {
        output.textContent = '// Error: ' + e.message;
    }
}

async function loadActuatorInfo() {
    const output = document.getElementById('actuator-result');
    output.textContent = t('actuatorLoadingInfo', '// Loading app info...');
    try {
        const res = await fetch('/actuator/info');
        const data = await res.json();
        output.textContent = JSON.stringify(data, null, 2);
    } catch (e) {
        output.textContent = '// Error: ' + e.message;
    }
}

/* ===== HELPERS ===== */

function escapeHtml(text) {
    const div = document.createElement('div');
    div.appendChild(document.createTextNode(String(text)));
    return div.innerHTML;
}

/* ===== INIT ===== */
document.addEventListener('DOMContentLoaded', () => {
    // Auto-load Kafka events on page load
    loadKafkaEvents();
});
