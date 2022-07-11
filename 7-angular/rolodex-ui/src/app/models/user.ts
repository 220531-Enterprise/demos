export class User {
// classes  enforce behavior around how an object can be initialized
  id: number;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  addresses: Address[];

  // ctrl + shift + p > TypeScript Constructor Generator
  constructor(
    id: number,
    firstName: string,
    lastName: string,
    username: string,
    password: string,
    email: string,
    addresses: Address[]
) {
    this.id = id
    this.firstName = firstName
    this.lastName = lastName
    this.username = username
    this.password = password
    this.email = email
    this.addresses = addresses
  }
}

export class Address {

  constructor(
    street: string,
    secondary: string,
    state: string,
    city: string,
    zip: string
) {
    this.street = street
    this.secondary = secondary
    this.state = state
    this.city = city
    this.zip = zip
  }

  street: string;
  secondary: string;
  state: string;
  city: string;
  zip: string;

}
