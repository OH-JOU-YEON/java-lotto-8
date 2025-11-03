# java-lotto-precourse

## 기능

- 주어진 금액만큼 로또를 발매하여 로또를 반환하는 기능 
- 로또의 당첨을 검사하는 기능
- 당첨의 수익률을 산출하는 기능
- 구입 금액을 입력받고 1000으로 나눠지지 않을 시 IllegalArgumentException을 발생시키고 예외 문구를 출력하는 기능
- 당첨 번호를 구분자와 함께 입력받고 개수가 잘못되었거나 구분자가 잘못된다면 IllegalArgumentException을 발생시키고 예외 문구를 출력하는 기능
- 보너스 번호를 입력받고 형태가 잘못되었다면 IllegalArgumentException을 발생시키고 예외 문구를 출력하는 기능
- 로또 수량과 번호를 출력하는 기능
- 당첨 내역을 출력하는 기능
- 잘못된 입력 발생 시 재입력 받는 기능  

<br>

## 구조 

#### LottoLauncherContorller에서 전체적인 흐름을 제어합니다.
#### InputViewService는 사용자에게 입력 기능을 제공합니다. 
- InputView로 입력을 받습니다.
- InputViewVerifier 클래스에서 입력을 검증하고 예외를 발생시킵니다.
- InputViewService에서는 InputView, InputViewVerifier이라는 두 객체의 상호작용을 담당합니다.
- 예외가 발생하면 예외를 처리하고 재입력을 받게 합니다. 
#### LottoMaker에서 로또와 보너스 번호를 발행합니다. 
- 로또 한 장의 가격을 가지고 있습니다.
- 싱글톤 패턴을 적용해 한 객체가 유지됩니다(로또 발매기는 한 대여야 일관성을 가진다고 생각했습니다).
#### LottoWinVerifier에서 당첨 내역을 검사해 저장합니다. 
- 검증기라 이름 붙였고, 검증기의 역할을 하지만 구매 회 당 검증기가 생성되므로 영수증이라고 이름지어도 괜찮을 듯 합니다. 
#### OutputView에서 출력을 담당합니다. 
