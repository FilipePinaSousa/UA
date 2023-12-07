var somameu = 0;
var asmeu = 0;
var aspc = 0;
var hidden;
var deck;
var canHit = True;



window.onload = function () {
    buildDeck();
    shuffleDeck();
    startGame();


    function buildDeck() {
        let values = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
        let types = ["C", "D", "H", "S"];
        deck = [];
        for (let i = 0; i < types.length; i++) {
            for (let j = 0; j < values.length; j++) {
                deck.push(values[j] + "-" + types[i]); //A-C -> K-C, A-D -> K-D
            }
        }
        // console.log(deck);
    }

}
function shuffleDecj() {
    let values = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    let types = ["C", "D", "H", "S"];
    deck = [];



}