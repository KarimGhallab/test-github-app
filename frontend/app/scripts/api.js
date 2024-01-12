const DOMAIN = 'http://localhost:5001';
const BASE_URL = `${DOMAIN}/api/account/v1/`;
const ICONS = {
  Eur: '<i class="fas fa-euro-sign"></i>',
  USD: '<i class="fas fa-dollar-sign"></i>',
};

function deposit() {
  const defaultAmount = 100;
  const args = { amount: defaultAmount, withLimit: true };
  const url = BASE_URL + 'deposit';
  $.get(url, args, (operationMessage) => updateAccount(operationMessage));
}

function withdraw() {
  const defaultAmount = 100;
  const args = { amount: defaultAmount };
  const url = BASE_URL + 'withdraw';
  $.get(url, args, (operationMessage) => updateAccount(operationMessage));
}

function getAccount() {
  const url = BASE_URL;
  $.get(url, (account) =>
    fillAccountData(account.id, account.balance, account.currency)
  );
}

function fillAccountData(accountId, accountBalance, accountCurrency) {
  const currencyIcon = ICONS[accountCurrency];
  $('#accountId').text(accountId);
  $('#accountBalance').text(accountBalance);
  $('#accountCurrency').html(currencyIcon);
}

function updateAccount({ status, title, message, balance }) {
  if (status === 'ok') {
    $('#accountBalance').text(balance);
  } else if (title !== '' && message !== '') {
    createWarningNotification(title, message);
  }
}

function createWarningNotification(title, message) {
  const html = `<article class="message is-warning">
  <div class="message-header">
    <p>${title}</p>
  </div>
  <div class="message-body">${message}</div>
</article>`;

  const addedElement = $(html).prependTo('.notification-container');

  addedElement
    .hide()
    .fadeIn(300)
    .delay(4000)
    .fadeOut(300, () => addedElement.remove());
}
