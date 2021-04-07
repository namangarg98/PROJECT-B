export class User{
      public username: string;
      public firstname: string;
      public lastname: string;
      public age:number;
      public password: string;


      constructor(username: string, firstname: string, lastname: string, age: number, password: string) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.password = password;
      }
}
