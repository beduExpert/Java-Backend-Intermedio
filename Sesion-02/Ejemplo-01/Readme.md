## Ejemplo 01: Usar Spring boot para crear un cliente rest

### Objetivos
* Usar los metodos comunes GET, POST, PUT y DELETE con la clase RestTemplate

### Prerequisitos
* Maven
* JDK 11

### Procedimiento

1. Crea el proyecto restMetodos con la dependencia de spring web y lombok
2. Crear la clase `Post` 
```java
   @Data
    public class Post {

        private int userId; 
        private int id;
        private String title;
        private String body;
        
        public Post() {

        }
        
        public Post(int userId, int id,String title, String body) {
            this.userId = userId;
            this.id = id;
            this.title = title;
            this.body = body;
        }


        public Post(int userId, String title, String body) {
            this.userId = userId;
            this.title = title;
            this.body = body;
        }
    }
```
3. En la clase RestMetodosApplication adentro del metodo main colocamos el siguiente codigo:
```java
    //get
		RestTemplate restTemplate = new RestTemplate();
		  Post[] posts = restTemplate
		    .getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);
		  
		  for(Post post : posts) {
			  System.out.println("GET "+ post);
		  }
		  
		  //post
		  restTemplate = new RestTemplate();
		  HttpEntity<Post> request = new HttpEntity<>(new Post(1,"foo", "barr"));
		  Post post = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", request, Post.class);
		
		  System.out.println("POST " + post);
		  
		//delete
		  restTemplate.delete("https://jsonplaceholder.typicode.com/posts/1");
		
		  
		//put
		  restTemplate = new RestTemplate();
		  request = new HttpEntity<>(new Post(1,1,"foasdldkasdkaso", "barr"));
		  HttpEntity<Post> response = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/1", HttpMethod.PUT ,request, Post.class);
		
		  System.out.println("PUT " + response.getBody());
```

4. Una vez terminado lo ejecutamos y vemos que nos imprime en consola el resultado







