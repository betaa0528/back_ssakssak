import{a as _,c,r as h,o as w,e as y,f as s,h as o,n as g,t as I,w as i,v as r,i as x}from"./index-DvTNLHIP.js";import{a as u}from"./authApi-Dh0TkU6y.js";const k={class:"mt-5 mx-auto",style:{width:"500px"}},D=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-user-plus"}),o(" 회원 가입 ")],-1),V={class:"mb-3 mt-3"},U={for:"id",class:"form-label"},B=s("i",{class:"fa-solid fa-user"},null,-1),E=s("label",{for:"avatar",class:"form-label"},[s("i",{class:"fa-solid fa-user-astronaut"}),o(" 아바타 이미지: ")],-1),N={class:"mb-3 mt-3"},S=s("label",{for:"email",class:"form-label"},[s("i",{class:"fa-solid fa-envelope"}),o(" email ")],-1),j={class:"mb-3 mt-3"},C=s("label",{for:"name",class:"form-label"},[s("i",{class:"fa-solid fa-user"}),o(" name ")],-1),M={class:"mb-3"},T=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),o(" 비밀번호: ")],-1),z={class:"mb-3"},A=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),o(" 비밀번호 확인: ")],-1),J=["disabled"],P=s("i",{class:"fa-solid fa-user-plus"},null,-1),G={__name:"JoinPage",setup(R){const p=_(),d=c(null),n=c(""),a=h({id:"test",name:"홍길동",email:"hong@gmail.com",password:"1212",password2:"1212",avatar:null}),t=c(!0),f=async()=>{if(!a.id)return alert("사용자 ID를 입력하세요.");t.value=await u.checkId(a.id),console.log(t.value,typeof t.value),n.value=t.value?"이미 사용중인 ID입니다.":"사용가능한 ID입니다."},v=()=>{t.value=!0,a.id?n.value="ID 중복 체크를 하셔야 합니다.":n.value=""},b=async()=>{if(a.password!=a.password2)return alert("비밀번호가 일치하지 않습니다.");d.value.files.length>0&&(a.avatar=d.value.files[0]);try{await u.create(a),p.push({name:"home"})}catch(m){console.error(m)}};return(m,e)=>(w(),y("div",k,[D,s("form",{onSubmit:x(b,["prevent"])},[s("div",V,[s("label",U,[B,o(" 사용자 ID : "),s("button",{type:"button",class:"btn btn-success btn-sm py-0 me-2",onClick:f},"ID 중복 확인"),s("span",{class:g(t.value.value?"text-primary":"text-danger")},I(n.value),3)]),i(s("input",{type:"text",class:"form-control",placeholder:"사용자 ID",id:"id",onInput:v,"onUpdate:modelValue":e[0]||(e[0]=l=>a.id=l)},null,544),[[r,a.id]])]),s("div",null,[E,s("input",{type:"file",class:"form-control",ref_key:"avatar",ref:d,id:"avatar",accept:"image/png, image/jpeg"},null,512)]),s("div",N,[S,i(s("input",{type:"email",class:"form-control",placeholder:"Email",id:"email","onUpdate:modelValue":e[1]||(e[1]=l=>a.email=l)},null,512),[[r,a.email]])]),s("div",j,[C,i(s("input",{type:"text",class:"form-control",placeholder:"Name",id:"name","onUpdate:modelValue":e[2]||(e[2]=l=>a.name=l)},null,512),[[r,a.name]])]),s("div",M,[T,i(s("input",{type:"password",class:"form-control",placeholder:"비밀번호",id:"password","onUpdate:modelValue":e[3]||(e[3]=l=>a.password=l)},null,512),[[r,a.password]])]),s("div",z,[A,i(s("input",{type:"password",class:"form-control",placeholder:"비밀번호 확인",id:"password2","onUpdate:modelValue":e[4]||(e[4]=l=>a.password2=l)},null,512),[[r,a.password2]])]),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:t.value},[P,o(" 확인 ")],8,J)],32)]))}};export{G as default};
