import{m as r}from"./index-DvTNLHIP.js";const o="/api/teacher",s={async uploadCsv(e){try{const t=await r.post(`${o}/class`,e,{headers:{"Content-Type":"multipart/form-data"}});return console.log("학생 CSV 데이터 업로드 성공:",t.data),t.data}catch(t){throw console.error("학생 CSV 데이터 업로드 실패:",t),t}},async getStudent(){try{return(await r.get(`${o}/student/list`)).data}catch(e){throw console.error("학생 목록을 불러오는 데 실패했습니다:",e),e}},async registStudent(e){try{const t=await r.post(`${o}/student/student-apply`,e);return console.log("학생 추가 성공:",t.data),t.data}catch(t){throw console.error("학생 추가 실패:",t),t}},async getJobList(){try{return(await r.get(`${o}/student/job-list`)).data}catch(e){throw console.error("직업 목록을 불러오는 데 실패했습니다:",e),e}},async registJob(e){try{const t=await r.post(`${o}/student/job-apply`,e);return console.log("직업 추가 성공:",t.data),t.data}catch(t){throw console.error("직업 추가 실패:",t),t}},async updateStudent(e){try{const t=await r.put(`${o}/student/update`,e);return console.log("student update successfully",t.data),t.data}catch(t){throw console.error("Failed to update student",t),t}},async updateJob(e){try{const t=await r.put(`${o}/student/job-update`,e);return console.log("job update successfully",t.data),t.data}catch(t){throw console.error("Failed to update job",t),t}}};export{s as a};
