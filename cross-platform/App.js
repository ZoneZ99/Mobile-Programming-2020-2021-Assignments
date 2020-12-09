import React, {Component} from 'react';
import {StyleSheet, View, Text, TextInput} from 'react-native';

class HelloWorld extends Component {
  state = {
    helloText: '',
  };

  render() {
    return (
      <View>
        <Text style={styles.helloText}>
          Hello, {this.state.helloText === '' ? 'World' : this.state.helloText}!
        </Text>
        <TextInput
          style={styles.helloInput}
          placeholder="Enter your name"
          defaultValue={this.state.helloText}
          onChangeText={(text) => this.setState({helloText: text})}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  helloText: {
    fontSize: 48,
    fontWeight: 'bold',
    textAlign: 'center',
    marginTop: 32,
  },
  helloInput: {
    fontSize: 24,
    textAlign: 'center',
    marginTop: 32,
  },
});

export default HelloWorld;
