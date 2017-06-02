import {Therapeut} from "./Therapeut";

export class Exercise{

  id: number;
  name: string;
  type: string;
  therapeut: Therapeut;

  constructor (id: number,  name: string,  type: string,  therapeut: Therapeut) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.therapeut = therapeut;
  }

  update(id: number,  name: string,  type: string,  therapeut: Therapeut) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.therapeut = therapeut;
  }
}
