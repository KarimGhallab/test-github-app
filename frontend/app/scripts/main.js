window.addEventListener('load', (_) => init());

function init() {
  //
  initUI();
  initWebPageWithData();
  getAccount();
  console.log('Feature 1: main');
}

function initUI() {
  const initButtons = () => {
    const buttonsContainer = document.querySelector('#login-buttons-container');

    const googleButton = `<button
  class="button is-info is-outlined"
  id="google-login-button"
  style="display: default"
>
  <span class="icon">
    <i class="fab fa-google"></i>
  </span>
  <span>Google login</span>
</button>`;
    buttonsContainer.innerHTML = googleButton;

    const microsoftButton = `<button
class="button is-link is-outlined"
id="microsoft-login-button"
>
<span class="icon">
  <i class="fab fa-microsoft"></i>
</span>
<span>Microsoft login</span>
</button>`;
    buttonsContainer.innerHTML += microsoftButton;

    const githubButton = `<button class="button is-dark is-outlined" id="github-login-button">
    <span class="icon">
    <i class="fab fa-github"></i>
    </span>
    <span>Github login</span>
    </button>`;
    buttonsContainer.innerHTML += githubButton;

    $('#google-login-button').click((_) => googleLogin());
    $('#github-login-button').click((_) => githubLogin());
  };

  const initCards = () => {
    const cardsContainer = document.querySelector('#cards-container');

    const standardCard = `<label style="margin-right: 20px">
    <input
      class="standard-card"
      type="radio"
      name="cards"
      value="standard"
      checked
      disabled
    />
    <img src="./images/cards/standard.png" />
  </label>`;
    cardsContainer.innerHTML = standardCard;

    const cashbackCard = `<label style="margin-right: 20px">
  <input
    class="cashback-card"
    type="radio"
    name="cards"
    value="cashback"
    disabled
  />
  <img src="./images/cards/cashback.png" />
  </label>`;
    cardsContainer.innerHTML += cashbackCard;

    const deferredCard = `<label>
  <input
    class="deferred-card"
    type="radio"
    name="cards"
    value="deferred"
    disabled
  />
  <img src="./images/cards/deferred.png" />
  </label>`;

    cardsContainer.innerHTML += deferredCard;
  };

  const initConverter = () => {
    console.log('Feature 1: initConverter');
    const converterContainer = document.querySelector('#converter-container');
    const converterHtml = `<div id="gcw_mainFDjTN2L9C" class="gcw_mainFDjTN2L9C"></div>
    <a id="gcw_siteFDjTN2L9C" href="https://freecurrencyrates.com/en/"
      >FreeCurrencyRates.com</a
    >`;

    converterContainer.innerHTML = converterHtml;
    var sc = document.getElementById('scFDjTN2L9C');
    if (sc) sc.parentNode.removeChild(sc);
    sc = document.createElement('script');
    sc.type = 'text/javascript';
    sc.charset = 'UTF-8';
    sc.async = true;
    sc.id = 'scFDjTN2L9C';
    sc.src =
      'https://freecurrencyrates.com/en/widget-vertical?iso=USD-EUR-GBP-JPY-CNY-XUL&df=2&p=FDjTN2L9C&v=fits&source=fcr&width=400&width_title=0&firstrowvalue=1&thm=A6C9E2,FCFDFD,4297D7,5C9CCC,FFFFFF,C5DBEC,FCFDFD,2E6E9E,000000&title=Currency%20Converter&tzo=-120';
    var div = document.getElementById('gcw_mainFDjTN2L9C');
    div.parentNode.insertBefore(sc, div);
  };

  initConverter();
  initButtons();
  initCards();
}

function initCardsButton() {
  $('input:radio[name="cards"]').change(function () {
    const args = { cardId: $(this).val() };
    const url = BASE_URL + 'setCard';
    $.get(url, args, (operationMessage) => updateAccount(operationMessage));
  });
}
