function applyHandler(formElement) {
   const data = $(formElement).serializeArray();
   console.log(formElement,data)
   const obj={};
   for (const field of data){
      obj[field.name]= field.value;
   }
   const $btn = $(formElement).find(".btn-primary").button('loading');
   $.ajax({
      url: '/mail/send',
      type: 'POST',
      data: JSON.stringify(obj),
      contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      success: function (msg) {
         if (msg.statusCode === 400){
            $.growl.error({title:"Ошибка" ,message: "Проверьте введенные даные" });
         }else {
         $('.modal').modal('hide');
            $.growl.notice({title:"Успех" ,message: msg });
         }
      },
      complete: function (){
         $btn.button('reset')
      },
      error: function (msg) {
         $.growl.error({title:"Неудача" ,message: "Что-то пошло не так! Попробуйте ещё раз позже" });
      }
         });
   return false;
}
