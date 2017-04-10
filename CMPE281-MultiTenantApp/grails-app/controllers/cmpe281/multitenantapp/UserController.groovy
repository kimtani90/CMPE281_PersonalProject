package cmpe281.multitenantapp

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

class UserController {

    def index = { }
    def login ={
        if (params.username == "grailslover" && params.password == "hi"){
            flash.message = "Welcome back, <B>${params.username}</B>."
            session.user = "grailslover"
        }else{
            flash.message = "Login failed"
        }
        redirect(action: 'fileupload')
    }
    def logout ={
        session.user = null
        redirect(action: 'index')
    }

   /* def fileupload = {
        def f = request.getFile('fileUpload')
        if(!f.empty) {
            flash.message = 'Your file has been uploaded'
            new File( grailsApplication.config.images.location.toString() ).mkdirs()
            f.transferTo( new File( grailsApplication.config.images.location.toString() + File.separatorChar + f.getOriginalFilename() ) )
        }
        else {
            flash.message = 'file cannot be empty'
        }
        redirect( action:index)
    }*/
    def fileupload = {
       /* HttpServletRequest originalRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(originalRequest);

       // MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
       // MultipartFile file = mhsr.getFile("attachments")*/
      def f = request.getFile('fileUpload')
        if (f.empty) {
            flash.message = 'file cannot be empty'
            render(view: 'index')
            return
        }

        f.transferTo(new File("D:\file_name.txt"))
        response.sendError(200, 'Done')
    }
}