/**
 * 입력 항목 validation
 * @returns {boolean}
 */
function invalid(){
    let check = true;
    let priceValid = true;
    // let passwdValid = true;

    const regPrice = /^[0-9]*$/;; //숫자만입력
    // const regPasswd = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;

    //금액 형식 확인
    if (regPrice.test($("#price").val()) === false) {
        console.log(1);
        $("#price").addClass('is-invalid');
        $("#price").removeClass('is-valid');
        $(".price-feedback").text("숫자(금액)만 입력해주세요.");

        priceValid = false;
    }
    //금액 값 null 확인
    if ($("#price").val() == '') {
        console.log(2);
        $("#price").addClass('is-invalid');
        $("#price").removeClass('is-valid');
        $(".price-feedback").text("금액을 입력 바랍니다.");
        priceValid = false;
    }

    // //비밀번호 형식 확인
    // if (regPasswd.test($("#passwd").val()) === false) {
    //     console.log(3);
    //     $("#passwd").addClass('is-invalid');
    //     $("#passwd").removeClass('is-valid');
    //     $(".passwd-feedback").text("잘못된 비밀번호 형식입니다. (문자 + 숫자 포함 9-16자리)");
    //
    //     passwdValid = false;
    // }
    //
    // //비밀번호 null 값 확인
    // if ($("#passwd").val() == '') {
    //     console.log(4);
    //     $("#passwd").addClass('is-invalid');
    //     $("#passwd").removeClass('is-valid');
    //     $(".passwd-feedback").text("비밀번호를 입력 바랍니다.");
    //     passwdValid = false;
    // }

    //금액 유효성 통과시 유효성 success 처리
    if (priceValid) {
        console.log(5);
        $("#price").removeClass('is-invalid');
        $("#price").addClass('is-valid');
    }

    // //비밀번호 유효성 통과시 유효성 success 처리
    // if (passwdValid) {
    //     console.log(6);
    //     $("#passwd").removeClass('is-invalid');
    //     $("#passwd").addClass('is-valid');
    // }

    //금액, 비밀번호 유효성 둘 중 하나라도 실패 시 false 리턴
    // if (!priceValid || !passwdValid) check = false;
    return check;
}