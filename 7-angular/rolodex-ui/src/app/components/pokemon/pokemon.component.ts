import { Pokemon } from './../../models/pokemon';
import { PokemonService } from './../../services/pokemon.service';
import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent {

  title: string = 'Catch Pokemon By Id'
  pokeId: number = 0;
  pokemon: Pokemon = new Pokemon(0, '', '');
  clientMessage: ClientMessage = new ClientMessage('');

  constructor(private pokemonService: PokemonService) { }

  catchPokemonById() {

    this.pokemonService.getPokemonById(this.pokeId)
    .subscribe({
      next: (data) => {
        this.pokemon.id = data.id;
        this.pokemon.pokeName = data.name;
        this.pokemon.sprite = data.sprites.front_default;
      },
      error: () => this.clientMessage.message = `Can't find the Pokemon with id ${this.pokeId}`,
      complete: () => console.log('complete')
    })

  }


}
